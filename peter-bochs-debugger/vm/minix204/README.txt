README.txt for the Minix-on-Bochs image. 

After installing Bochs 2.1.1, this directory should be installed as 
C:\Program Files\Bochs 2.1.1\minix204. 

This is based on the DOSMinix version of Minix 2.0.4. The  FIX.TAZ
updates of Nov 30, 2003 are installed. Both standard and networked 
Minix system files are included. You can run the non-networked version
with the supplied minix.bxrc configuration file as is. You will have 
to edit minix.bxrc to enable networking and to use virtual or physical
floppy disks and CD-ROMs. See the comments in minix.bxrc. 

Read the Minix on Bochs on Windows How-to included here in the Howto
directory or online at http://minix1.hampshire.edu/faq/bxmxhowto.html
or the corresponding directory at minix1.bio.umass.edu.

Files in this directory

These are the two essentials:

minix.bxrc     -- Bochsrc (runtime configuration) for Minix on Bochs
minix.img      -- the virtual hard disk file 

Floppy disk images

root.img       -- Minix installation boot disk
usr.img        -- Minix installation /usr disk
vfloppya.img   -- virtual disk with mountable Minix file system
vfloppyb.img   -- virtual disk formatted with MS-DOS  

run.bat        -- startup script, convenience, not necessary

Extras subdirectory 

minix.ico      -- Minix icon
Minix 2.0.4... -- shortcut to run.bat for desktop
mkfile.com     -- utility to create a new virtual hard disk
boot.com       -- boot program for starting DOSMinix (not used with Bochs)
readme.htm     -- DOSMinix readme as html
readme.txt     --    "       "    as text 

Howto directory

bxmxhowto.html -- Start here: Minix on Bochs on Windows page
rundlx.html    -- Running the DLX Linux Demo
mxbxpcap.html  -- Minix-Bochs-WinPCap page
locethad.html  -- Choosing your own ethernet address
vdiskfun.html  -- Fun With Virtual Disks
diskexpl.html  -- About DiskExplorer

(Please read these online at minix1.hampshire.edu/faq/bxmx.html if
possible, there may be newer versions, and all links will work.)

ASW 2004-03-08