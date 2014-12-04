android-viewpager-play
======================

Implementing an example soundboard app that uses the Android ViewPager Layout Manager

Demos
-----
![Animated Gif (no sound)](./demos/simple_soundboard_demo.gif)<br>
Current state of things, will update .gif as I add more features.

So, a brief description of the app.  The idea to create a multipage framework for creating a soundboard app which could
easily be customized by basically just replacing the files that exist in the res/raw directory and recompiling the app.
Currently, the app gets a file listing of this directory and creates a series of buttons on each page (naming the buttons
based on the file names), with parameters to controls how many buttons per row and buttons per page.

Future work
-----------
Integrated MySqlLite db with interesting sounds, proper sound titles and potentially images.
Create a script for programmatically generating the data for the database given a bunch of mp3s (Potentially extract the title of the .mp3 from the ID3 tag?)
Look into replacing currently use of MediaPlayer with SoundPool to play multiple sounds simutaneously.
Added options for using sound as ringtone or notification.

Links
-----
http://developer.android.com/reference/android/support/v4/view/ViewPager.html
https://github.com/astuetz/PagerSlidingTabStrip
