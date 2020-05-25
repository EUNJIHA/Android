# Task
1. 첫번째 조사: App Fundamental
2. 두번째 조사: Layout
3. UI 실제 Product 기반으로 만들기
---
4. Intent와 Life Cycle (다음 주에)

## 🎁 Feedback
### 1. LinearLayout과 RelativeLayout
   
LinearLayout으로도 할 수 있는데 RelativeLayout으로 한 이유가 있나? (실제로 Linear가 더 성능이 좋다고 하네) 처음에는 RelativeLayout이 더 유연해서 Linear보다 좋지 않을까 생각했는데, Relative는 Linear가 할 수 없는 어떤 것이 있을지 생각해보기. (Linear는 stack 구조 처럼 쌓이는 형태임을 인지하고 있을 것)

### 2. FrameLayout
   
FrameLayout은 꼭 필요한 경우가 아니라면 전체 구조에 사용하는 것을 지양하는게 좋다. *(음, 근데 아직 FrameLayout 와닿지 않는다.)*

* 예시: SNS의 알림 숫자  

    ![image](https://user-images.githubusercontent.com/43839938/82798061-fc26f400-9eb2-11ea-8fad-76644aadc3e4.png)

    이 예시의 경우 자체가 이미지가 아니다. `22`와 같은 숫자들은 매번 바뀌는데 숫자가 포함된 이미지를 매번 갈아 끼울 수는 없기 때문이다. 



### 3. Color Picker
   
아이콘을 따와서 집어넣어야 했는데, 배경과 색깔이 맞지 않았음. 그럴 때 Color Picker Tool 사용하기 (가령, [imagecolorpicker 사이트](https://imagecolorpicker.com/))

### 4. Relative Layout의 여러 속성들

[[RelativeLayout.LayoutParams] Document](https://developer.android.com/reference/android/widget/RelativeLayout.LayoutParams)

#### 1) 상대적 위치  
android:layout_above  
android:layout_below  
android:layout_toStartOf  
android:layout_toEndOf  
android:layout_toLeftOf  
android:layout_toRightOf  

#### 2) 가운데  
android:layout_centerHorizontal  
android:layout_centerVertical  

#### 3) 선 맞추기  
android:layout_**align**XXX

### 5. padding, margin
<img src="https://user-images.githubusercontent.com/43839938/82796767-0cd66a80-9eb1-11ea-8838-8e1364bd5ed8.png" width="400" height="300">  

[이미지 출처](https://sharp57dev.tistory.com/26)
#### 1) margin
**부모 Layout의 테두리**와 **해당 View의 테두리** 까지의 여백

#### 2) padding
**해당 View의 테두리**와 **그 View 안의 내용**까지의 여백

사용자가 아이콘 선택해야 할 때, `padding`을 통해 더 넓은 범위에서 선택할 수 있도록 돕는다.

> Designer에게 아예 요구할 수 있는 부분이기도 함

### 6. GridLayout과 TableLayout의 차이
- GridLayout은 여러 행/열을 합칠 수 있다. 
- GridLayout은 나중에 나온 버전. TableLayout의 단점을 보완? 메모리, 더 효율적 
- 어떤 블로그에서는 내용이 많을 경우 Grid를 사용하라고 ? 
### 7. 기기의 다양성

기기의 다양성(작고, 옆으로 넓고, 크고 등등) 으로 인해 View에 절대적인 값을 주기보다 weight나 margin등을 

### 8. 기타
- `ScrollView`는 **하나의 Child**만 갖는다
- `ConstraintLayout`은 dp 등으로 설정 안하고 **비율 설정** 가능하다.  
  가중: 체인이 넓히기 또는 내부에서 넓히기로 설정되면 하나 이상의 보기를 '제약조건과 일치'로 설정하여 나머지 공간을 채울 수 있습니다(0dp). 기본적으로 공간은 '제약조건과 일치'로 설정된 각 보기 사이에 균등하게 분배되지만, `layout_constraintHorizontal_weight` 및 `layout_constraintVertical_weight` 속성을 사용하여 각 보기에 중요도 가중치를 할당할 수 있습니다. `선형 레이아웃의 layout_weight`와 작동 방식이 동일합니다.

