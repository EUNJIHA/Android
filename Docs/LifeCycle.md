# Activity 생명주기(Life Cycle)

[[공식문서] - Understand the Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle#top_of_page)

1. 구성 변경을 유지하고 
2. 메모리 누수를 방지하며 
3. UI에 쉽게 데이터를 로드합니다.


콜백이 실행되는 동안 **내부에서 어떤 일이 일어나고**, **그 과정에서 무엇을 구현해야 하는지** 살펴보자. [참고](https://developer.android.com/topic/libraries/architecture)


## 🚩요약
`onCreate()`: 1. 매개변수인 `Bundle savedInstanceState`를 통해 이전 상태를 불러오기 2. Activity를 위한 레이아웃 UI를 설정 3. Activity 안의 멤버 변수를 초기화

`onRestart()`: 보통은 아무 작업 안함 (stop 후 restart 되었을 때 필요한 작업이면 진행) 

`onStart()`: 1. 애니메이션 재개 처리 2. GPS 처리 3. 부가적인 DB 정보 불러오기

`onResume()`: 1. 카메라 미리보기 시작

`onPause()`: 1. 카메라 미리보기 정지

`onStop()`: 1. 애니메이션을 일시정지 2. 세밀한 위치 업데이트에서 대략적인 위치 업데이트로 전환 3. 부가적인 큰 정보들 DB에 저장

`onDestroy()`: 1. 위에서 처리하지 못한 리소스 해제

## 🚩의의
적절한 시점에 적절한 작업을 수행하고 적절하게 전환을 처리하면 **앱이 더욱 안정적이고 성능을 잘 발휘할 수 있다.** 

## 🚩예시
예를 들어 스트리밍 동영상 플레이어를 빌드하는 경우, 사용자가 다른 앱으로 전환할 때 비디오를 일시 중지하고 네트워크 연결을 종료할 수 있다. 사용자가 돌아오면, 네트워크를 다시 연결하고 사용자가 일시 중지한 지점에서 동영상을 다시 시작할 수 있게 할 수 있다. 

수명 주기 인식 구성요소를 사용하면 다양한 사례의 수명 주기를 훨씬 쉽게 관리할 수 있다. 몇 가지 예는 다음과 같다.

* 대략적인 위치와 세분화된 위치 업데이트 간 전환. 수명 주기 인식 구성요소를 사용하면 위치 앱이 공개 상태인 동안 세분화된 위치 업데이트를 사용하고 앱이 백그라운드에 있을 때 대략적인 위치 업데이트로 전환할 수 있습니다. 수명 주기 인식 구성요소인 LiveData를 사용하면 사용자가 위치를 변경할 때 앱에서 자동으로 UI를 업데이트할 수 있습니다.
* 동영상 버퍼링 중지와 시작. 수명 주기 인식 구성요소를 사용하면 동영상 버퍼링을 최대한 빨리 시작하지만, 앱이 완전히 시작될 때까지 재생을 연기합니다. 또한 수명 주기 인식 구성요소를 사용하여 앱이 제거될 때 버퍼링을 종료할 수 있습니다.
* 네트워크 연결 시작과 중지. 수명 주기 인식 구성요소를 사용하면 앱이 포그라운드에 있는 동안 네트워크 데이터를 실시간으로 업데이트(스트리밍)할 수 있으며 앱이 백그라운드로 전환될 때 실시간 업데이트를 자동으로 일시중지할 수도 있습니다.
* 애니메이션 드로어블 일시중지와 재개. 수명 주기 인식 구성요소를 사용하면 앱이 백그라운드에 있는 동안 애니메이션 드로어블 일시중지를 처리하고 앱이 포그라운드로 전환한 후 드로어블을 재개할 수 있습니다.


[[참고] - UI 상태 저장](https://developer.android.com/topic/libraries/architecture/saving-states)

## 🚩각 사이클 별 콜백함수
### 🎁onCreate

#### 1. 언제?
- 맨 처음 Activity를 실행시킬 때

#### 2. 예제

onCreate() 메서드에서 Activity의 **전체 수명 주기 동안 한 번만 발생해야 하는 기본 애플리케이션 시작 로직**을 수행한다. 예를 들어 onCreate()를 구현하면 1) 데이터를 목록에 바인딩하고, 2) Activity를 ViewModel과 연결하고, 3) 일부 클래스 범위 변수를 인스턴스화할 수 있다. 

```java
//다음과 같이 처음에 한번 초기화가 필요한 멤버 변수 초기화 
private EditText mEditView; 

@Override public void onCreate(Bundle savedInstanceState) {     
    super.onCreate(savedInstanceState); 

    // Activity를 위한 레이아웃 UI를 설정을 할 때 이용 
    setContentView(R.layout.activity_main); 

    // Activity 안의 멤버 변수를 초기화 할 때 이용 
    mEditView = (EditText) findViewById(R.id.edit_message); 

    //아래 ActionBar를 이용하기 전에 API 버전을 확인해본다. 
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) { 
        // 아래와 같이 MainActivity의 ActionBar의 아이콘은 버튼의 기능을 가지지 않게 설정하는 등 UI를 설정할 때 이용 
        ActionBar actionBar = getActionBar(); actionBar.setHomeButtonEnabled(false); 
    } 
        // 이러한 앱의 전반적으로 계속 진행해야하는 스레드의 초기화도 이용 
        Debug.startMethodTracing(); 
}
```

### 🎁onRestart

> onRestart 콜백 함수는 `onStop()`에 있다가 `onStart()` 상태로 갈때에만 호출되는 콜백 함수로 `onStop()` 상태에서 `onStart()`로 갈 때에 특별하게 처리하거나 복원해야하는 정보를 이 콜백 함수 안에서 처리하면 된다. 

> 시스템에서는 기본적으로 Activity 인스턴스의 정보를 유지시켜주기 때문에 많은 앱들은 굳이 `onRestart()`를 구현하지 않아도 될 것이다. 왜냐하면 `onRestart()`될 때에는 이후 `onResume()`의 콜백 함수를 수반하기 때문이다.


아래는 GPS 리소스 점검에 대한 간단한 예이다.
```java
@Override protected void onStart() { 
    super.onStart(); 
// Activity가 처음으로 시작하거나 다시 시작한 상태이다. 따라서 GPS의 사용가능 여부를 검사한다. 
LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    if (!gpsEnabled) { 
    // GPS가 사용가능하지 않다면 사용자에게 요청하는 다이얼로그를 띄우고 처리한다. 
    // android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS 인텐트로 GPS 설정을 유도한다. 
    } 
} 
@Override protected void onRestart() {
     super.onRestart(); 
     // onStart에서 설정을 하므로 onRestart에서는 특별히 할게 없어진다. 
}
```


### 🎁onStart
Activity가 사용자에게 보이게 된다. 이 메소드는 매우 빠르게 완료된다.
#### 1. 언제?
- `onCreate()` 이후 
- `onStop()` -> `onRestart()` 이후에도 호출된다.
#### 2. 예제
통신이나 센서 처리

### 🎁onResume
Activity와 상호작용할 수 있는 단계

#### 1. 언제?
- `onStart()` 이후
- `onPause()` 이후
- 따라서 `onResume()`을 구현하여 **`onPause()` 중에 해제하는 구성요소를 초기화**하고, Activity가 **`onResume()` 상태로 전환될 때마다 필요한 다른 초기화 작업**도 수행해야 합니다.

#### 2. 예제

구성요소가 ON_RESUME 이벤트를 수신할 때 카메라에 액세스하는 수명 주기 인식 구성요소의 예시는 다음과 같다.

```java
public class CameraComponent implements LifecycleObserver {

    ...

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void initializeCamera() {
        if (camera == null) {
            getCamera();
        }
    }

    ...
}
```

* Activity가 `onPause()` 상태이지만 표시되어 있는 동안(예: 멀티 윈도우 모드) 카메라를 활성 상태로 유지하고 싶을 때 (그러나 Activity가 `onPause` 상태일 때 카메라를 활성화하면 멀티 윈도우 모드에서 `onResume` 상태에 있는 다른 앱이 카메라에 액세스하지 못할 수도 있다.)

### 🎁onPause
#### 1. 언제? 
##### onPause() -> onStop()
- Activity를 떠나는 첫 시점
##### onPause()까지만. 다시 포커징 받으면 onResume()
- 반투명 Activity가 덮어질 때 (Dialog 형태일 수도)
- 멀티윈도우 상황에서 포커징이 안되어 있는 Activity

#### 2. 예제
또한 onPause() 메서드를 사용하여 **시스템 리소스, 센서 핸들(예: GPS) 또는 Activity가 일시정지 중이고 사용자가 필요로 하지 않을 때 배터리 수명에 영향을 미칠 수 있는 모든 리소스를 해제**할 수 있다. 

구성요소가 포그라운드에 있지 않을 때 실행할 필요가 없는 기능을 모두 정지할 수 있다(예: 카메라 미리보기 정지).
```java
public class JavaCameraComponent implements LifecycleObserver {

    ...

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void releaseCamera() {
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }

    ...
}
```
그러나 앞서 onResume() 섹션에서 언급했듯이 일시정지된 Activity는 **멀티 윈도우 모드**에서 여전히 완전히 보이는 상태일 수 있다. 그러므로 **멀티 윈도우 모드를 더욱 잘 지원하기 위해** UI 관련 리소스와 작업을 완전히 해제하거나 조정할 때는 **`onPause()` 대신 `onStop()`을 사용하는 것이 좋다.**

`onPause()`는 아주 잠깐 실행되므로 저장 작업을 수행하기에는 시간이 부족할 수 있다. **그러므로 onPause()를 사용하여 애플리케이션 또는 사용자 데이터를 저장하거나, 네트워크 호출을 하거나, 데이터베이스 트랜잭션을 실행해서는 안된다.**

### 🎁onStop

#### 1. 언제?
- 
여기에서 수명 주기 구성요소는 구성요소가 화면에 보이지 않을 때 실행할 필요가 없는 기능을 모두 정지할 수 있습니다.

#### 2. 예제
onStop() 메서드에서는 앱이 **사용자에게 보이지 않는 동안** 앱은 **필요하지 않은 리소스를 해제하거나 조정**해야 합니다. 예를 들어 앱은 **애니메이션을 일시정지**하거나, **세밀한 위치 업데이트에서 대략적인 위치 업데이트로 전환**할 수 있습니다.

onPause() 대신 onStop()을 사용하면 사용자가 멀티 윈도우 모드에서 Activity를 보고 있더라도 UI 관련 작업이 계속 진행됩니다.

또한 onStop()을 사용하여 **CPU를 비교적 많이 소모하는 종료 작업**을 실행해야 합니다. 예를 들어 정보를 **데이터베이스에 저장**할 적절한 시기를 찾지 못했다면 onStop() 상태일 때 저장할 수 있습니다. 
```java
@Override
protected void onStop() {
    // call the superclass method first
    super.onStop();

    // save the note's current draft, because the activity is stopping
    // and we want to be sure the current note progress isn't lost.
    ContentValues values = new ContentValues();
    values.put(NotePad.Notes.COLUMN_NAME_NOTE, getCurrentNoteText());
    values.put(NotePad.Notes.COLUMN_NAME_TITLE, getCurrentNoteTitle());

    // do this update in background on an AsyncQueryHandler or equivalent
    asyncQueryHandler.startUpdate (
            mToken,  // int token to correlate calls
            null,    // cookie, not used here
            uri,    // The URI for the note to update.
            values,  // The map of column names and new values to apply to them.
            null,    // No SELECT criteria are used.
            null     // No WHERE columns are used.
    );
}
```


### 🎁onDestroy

#### 1. 언제?
- 사용자가 Back 버튼을 눌렀을 때
- Activity 안에서 finish() 함수를 호출하여 자체적으로 종료할 때
- Stop 된 상태에서 오랫동안 사용하지 않을 때
- Stop 된 상태에서 전면에 있는 Activity가 더 많은 리소스가 필요할 때 메모리 확보를 위해
- 사용자가 화면을 회전 시켰을 때

#### 2. 예제

`onDestroy()` 콜백은 이전의 콜백에서 아직 해제되지 않은 모든 리소스(예: `onStop()`)를 해제해야 한다.


> 일반적으로는 모든 변수들이 garbage collect 되기도 하고, 기본적으로 onPause와 onStop 함수 안에 모든 메모리를 잡아먹는 인스턴스를 해제하는 것이 권장되기 때문에, onDestroy 함수를 건드리는 일은 별로 없을 것이다. 하지만 위의 예에서 처럼 만약에 앱 전반적으로 실행한 스레드가 있어서 그것이 메모리 leak으로 이어지거나 리소스 낭비로 이어지게 된다면 이는 필수적으로 onDestroy에서 해제를 해줘야할 것이다.


```java
 @Override
    protected void onDestroy() {
    	super.onDestroy();
    	//앱의 전반적으로 돌아가던 스레드를 종료할 때
    	Debug.stopMethodTracing();
    }
```

> 만약 onCreate에서 다른 Activity를 호출하고 finish()를 onCreate 함수 내에서 호출하게 된다면 onPause와 onStop 함수를 거치지 않고 바로 onDestroy로 호출되므로 이러한 경우 프로세스 흐름에 주의를 요하자.

> 이런 경우를 대비해서 onDestroy에 해제 해야 할 리소스가 있는지 살피는 것 ?

onPause()와 onStop()이 호출되지 않을 수도 있다는 것이 이런 경우이다.



## 기타
- 기본적으로 시스템에서는 `Bundle`의 데이터를 이용해서 각 View 위젯의 상태에 대해서 저장하게 된다. 따라서 Destroy 되었다가 다시 생성되는 경우 사용자는 **아무런 추가 작업없이 View의 상태들이 유지된다.** 하지만 Activity가 자체적으로 가지고 있던 여러 가지 상태 정보들은 가지고 있지 않으므로 이를 저장하고 복원시키는 작업도 필요할 것이다.  
안드로이드 시스템에서 자동으로 View의 상태들을 복원시키려면 각 View는 반드시 android:id로 설정한 **유니크한 id를 가지고 있어야한다**.

- **리소스 생성과 소멸**은 **대칭이 되는 생명주기 메서드**에서 실행해야 한다. onCreate()에서 DB를 열었다면 onDestroy()에서 닫아야 한다. onCreate-onDestory, onResume-onPause, onStart-onStop 이 서로 대칭이 된다. 만약 onCreate에서 DB를 열고 onPause에서 DB를 닫으면 오류가 발생할 수 있다. 만약 A 액티비티에서 B액티비티로 전환하고 back 키를 눌러 A 액티비티로 돌아왔을 때 A 액티비티에서는 onPause 호출로 DB가 닫혔지만 다시 돌아왔을 때 onCreate 호출이 되지 않아 DB가 안 열린다. 이와 같은 상황이 올 수 있기에 대칭으로 생명주기를 사용하는 게 좋다.

- onDestroy (메모리 부족해서 시스템 상으로 종료될 때) 이후 onCreate될 때 UI의 상태를 보존시키고 싶다?

	⁃	Instance State ( xml에 고유 ID 값을 줘야 자동 저장 됨), 하지만 이것은 극소량의 데이터만 저장 가능
	⁃	따라서 그 이상의 무거운 데이터들을 저장하고 싶을 때는 1) persistent local storage, 2) the onSaveInstanceState() method, 3) and the ViewModel class, as outlined in Saving UI States. 을 사용해야 함



## Reference
[[Android(안드로이드) 앱 개발 기초] Activity 라이프사이클 공부](https://unikys.tistory.com/276)  
[안드로이드 액티비티(Activity) 생명주기 총정리](https://programmingfbf7290.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%A1%ED%8B%B0%EB%B9%84%ED%8B%B0Activity-%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0-%EC%B4%9D%EC%A0%95%EB%A6%AC)
[[Android] Activity와 Fregment의 생명주기](https://re-build.tistory.com/4)