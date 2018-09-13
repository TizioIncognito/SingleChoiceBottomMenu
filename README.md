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


### License
Copyright (c) 2018 TizioIncognito (https://github.com/TizioIncognito).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
