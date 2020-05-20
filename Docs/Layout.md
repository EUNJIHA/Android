# Layout

Linear
Relative
Frame
Table
Grid
Constraint
Fragment

# User interface


## 1. Layouts
레이아웃은 앱에서 사용자 인터페이스를 위한 구조(예: 액티비티)를 정의합니다. 레이아웃의 모든 요소는 `View`와 `ViewGroup` 객체의 계층을 사용하여 빌드됩니다. 일반적으로 `View`는 사용자가 보고 상호작용할 수 있는 것을 그립니다. `ViewGroup`은 그림 1과 같이 View와 다른 ViewGroup 객체의 레이아웃 구조를 정의하는 투명 컨테이너입니다.

![image](https://user-images.githubusercontent.com/43839938/82417490-969fc580-9ab6-11ea-99a9-f91285185592.png)

![image](https://user-images.githubusercontent.com/43839938/82417739-f1392180-9ab6-11ea-836a-04b2c75aaa4f.png)

### 1) LinearLayout
![image](https://user-images.githubusercontent.com/43839938/82420017-2004c700-9aba-11ea-9ea1-fa203cb9b7f4.png)
![image](https://user-images.githubusercontent.com/43839938/82420265-77a33280-9aba-11ea-84eb-d173ad33c9ca.png)
### 2) RelativeLayout
![image](https://user-images.githubusercontent.com/43839938/82422483-79bac080-9abd-11ea-8bd1-b820cf781d98.png)
![image](https://user-images.githubusercontent.com/43839938/82420305-825dc780-9aba-11ea-8a94-a19e28d44cff.png)
![image](https://user-images.githubusercontent.com/43839938/82420330-8c7fc600-9aba-11ea-9973-220ceca15233.png)
![image](https://user-images.githubusercontent.com/43839938/82420353-95709780-9aba-11ea-8d70-4cfe7ad2a39a.png)

### 3) FrameLayout
`FrameLayout`은 주로 하나의 자식만 표시할 때 사용한다. 여러 자식을 추가하면 스택 구조로 겹쳐진다. 즉, 제일 최근에 추가한 자식이 제일 위로 온다.
(참고로 `Fragment`는 `FrameLayout`에서 많이 사용되는 예 중 하나이다.)

![image](https://user-images.githubusercontent.com/43839938/82421541-2136f380-9abc-11ea-8677-dc993e7af730.png)

![image](https://user-images.githubusercontent.com/43839938/82420424-a9b49480-9aba-11ea-928d-98d569305a4d.png)
### 4) TableLayout
`TableLayout`은 행과 열로 자식들을 구성한다. 보통 `TableRow`를 자식으로 갖는다. `TableRow` 중 가장 많은 열(Column)의 개수가 `TableLayout` 의 개수가 된다. (참고로 `TableLayout`은 `LinearLayout`에 종속된다.)

![image](https://user-images.githubusercontent.com/43839938/82421100-83dbbf80-9abb-11ea-9f2a-339ea34097b8.png)

![image](https://user-images.githubusercontent.com/43839938/82420500-bf29be80-9aba-11ea-91e5-2506fd4e2b92.png)
### 5) GridLayout
### 6) ConstraintLayout
[](https://developer.android.com/training/constraint-layout)


## 2. Others





