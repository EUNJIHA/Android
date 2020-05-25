- [다양한 픽셀 밀도 지원](https://developer.android.com/training/multiscreen/screendensities#TaskUseDP)

    밀도가 서로 다른 화면에서 UI 표시 크기를 유지하려면 **밀도 독립형 픽셀(dp)** 을 측정 단위로 사용해서 UI를 디자인해야 합니다.

    **텍스트 크기**를 정의하는 경우에는 **확장 가능 픽셀(sp)** 을 단위로 사용해야 합니다(단, 레이아웃 크기에는 sp를 사용하지 않아야 함). sp 단위는 기본적으로 dp와 같은 크기이지만, 사용자가 선호하는 텍스트 크기에 따라 크기가 조절됩니다. (사용자가 시스템 상으로 설정한 크기에 종속)


* [Linear Layout의 layout_weight](https://developer.android.com/guide/topics/ui/layout/linear)
  
  각 하위 요소가 화면에서 동일한 크기의 공간을 사용하는 선형 레이아웃을 생성하려면 각 뷰에 대한 **android:layout_height를 "0dp"로 설정하거나(세로 레이아웃의 경우) 각 뷰에 대한 android:layout_width를 "0dp"로 설정합니다(가로 레이아웃의 경우).**
  
 