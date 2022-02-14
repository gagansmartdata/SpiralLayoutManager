# SpiralView

Simple in usage Recycler Layout Manager with spiral item positioning.

|  ![](spiralSample.gif)|


## Usage
Just add a `CurveLayoutManger` as a layout manager for your recycler view.
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val curveLayoutManger = CurveLayoutManger(ACurve(),this)
              circularRecycler.layoutManager = curveLayoutManger
              circularRecycler.adapter = Adapter()
    }
}
```