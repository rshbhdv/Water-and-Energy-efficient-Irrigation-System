
#############################################################################
#################### To be modified by user  ################################

# Put your own source file names in APPSRC. 
APPSRC += bcast_coord.c

##output file name is to be given in TARGET variable.
TARGET = sensenuts_bcastCoord

#############################################################################


# Do not modify following lines

export APP_BASE 			= $(abspath .)
export APP_OUTPUT			= $(APP_BASE)/output
export APP_BLD_DIR          = $(APP_BASE)
export APP_SRC_DIR         	= $(APP_BASE)/source
export APPSRC
export TARGET
DIRS	= "../../../Lib"

TARGETS: clean all

all:
	-for d in $(DIRS); do (cd $$d; $(MAKE) $(MFLAGS) all ); done

clean:  
	-for d in $(DIRS); do (cd $$d; $(MAKE) $(MFLAGS) clean ); done

