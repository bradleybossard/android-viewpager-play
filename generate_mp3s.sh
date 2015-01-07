for i in {0..100}; do 
  leading_zeros=`printf %03d $i`
  songString="Test Sound $i"
  #say -o "sound_"$leading_zeros".aiff" "Test Sound $i"
  aiffname="sound_"$leading_zeros".aiff"
  mp3name="sound_"$leading_zeros".mp3"
  #say -o $aiffname "Test Sound $i"
  say -o $aiffname songString

#done

#for file in $(ls *.aiff); do
  #filebase=`basename $file .aiff`
  #lame -m m $file $filebase.mp3;
  lame -m m --tt "$songString" $aiffname $mp3name;
  #id3tag --song="$songString" $mp3name;
done;
