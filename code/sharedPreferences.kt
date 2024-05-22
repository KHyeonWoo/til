//앱 저장공간에 데이터를 저장해서 앱을 재실행 해도 값을 불러올 수 있는 코드
val activity = LocalContext.current as? Activity
val sharedPref = remember {
    activity?.getPreferences(Context.MODE_PRIVATE)
}
var sizeNum by remember {
    val savedSize = sharedPref?.getInt("size", 0)
    mutableIntStateOf(savedSize ?: 0)
}
