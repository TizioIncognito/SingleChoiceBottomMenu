# SingleChoiceBottomSheetMenu
An android library to show a single choice menu from bottom with a BottomSheetDialogFragment


<img src="./img/img1.png" width="250" />


### Example

    SingleChoiceBottomSheetMenu
       .create()
       .setMenuTitle("Title single choice")
       .setMenuSubTitle("Subtitle single choice")
       .addMenuItem(R.drawable.camera, "Take a picture",
                    "Take a picture description") { 
               //OnClick
           }
       .addMenuItem(R.drawable.qrcode_scan, "Read qrCode",
                    "Read qrCore description") { 
               //OnClick
           }
       .addMenuItem(R.drawable.pencil, "Modify",
                    "Modify description") { 
			   //OnClick
           }
       .show(activity.supportFragmentManager)
