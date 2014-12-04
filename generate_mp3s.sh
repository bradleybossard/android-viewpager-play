for i in {1..100}; do 
  leading_zeros=`printf %03d $i`
  say -o "sound_"$leading_zeros".aiff" "Test Sound $i"
done

for file in $(ls *.aiff); do
  filebase=`basename $file .aiff`
  lame -m m $file $filebase.mp3;
done;
