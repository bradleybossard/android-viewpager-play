android-viewpager-play
======================

Implementing an example soundboard app that uses the Android ViewPager Layout Manager

Demos
-----
![Animated Gif (no sound)](./demos/simple_soundboard_demo.gif)<br>
Current state of things, will update .gif as I add more features.

Currently, app just contains a bunch of sample .mp3s I generated using OSX say command (script located at ./generated_mp3.sh)

Future work
Integrated MySqlLite db with interesting sounds, proper sound titles and potentially images.
Look into replacing currently use of MediaPlayer with SoundPool to play multiple sounds simutaneously.
Added options for using sound as ringtone or notification.

Links
-----
http://developer.android.com/reference/android/support/v4/view/ViewPager.html
https://github.com/astuetz/PagerSlidingTabStrip
