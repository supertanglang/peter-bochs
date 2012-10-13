svn log ../ -r 1:HEAD --xml --verbose --quiet > my-project-log.xml
gource my-project-log.xml

#video
gource my-project-log.xml -1280x720 -o gource.ppm --title 'Peter-bochs debugger'
ffmpeg -y -r 60 -f image2pipe -vcodec ppm -i gource.ppm -vcodec libx264 -preset ultrafast -crf 1 -threads 0 -bf 0 gource.mp4

