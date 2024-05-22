
var imageUri by remember {
    mutableStateOf<Uri?>(null)
}

val pickMedia =
    rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        imageUri = uri
    }
//Uri 를 사용해서 이미지를 띄우려면 아래 라이브러리 사용해야함
//\app\build.gradle.kts 제일 아래 dependencies 에 추가
//implementation("io.coil-kt:coil-compose:2.6.0")

    
// Launch the photo picker and let the user choose images and videos.
pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageAndVideo))

// Launch the photo picker and let the user choose only images.
pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))

// Launch the photo picker and let the user choose only videos.
pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.VideoOnly))

// Launch the photo picker and let the user choose only images/videos of a
// specific MIME type, such as GIFs.
val mimeType = "image/gif"
pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.SingleMimeType(mimeType)))

Image(
//    painter =  painterResource(id = imageId),
  //요렇게 호출!
    painter =  rememberAsyncImagePainter(imageUri),
    contentDescription = "image",
    modifier = Modifier
        .fillMaxSize()
        .clip(imageShape[shapeNum]),
    contentScale = ContentScale.Crop
)
