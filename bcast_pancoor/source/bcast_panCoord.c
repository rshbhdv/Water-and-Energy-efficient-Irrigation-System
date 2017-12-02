/*All rights reserved.
 *
 * Eigen Technologies Pvt. Ltd.
 * New Delhi
 * www.eigen.in
 *
 * This source code is provided to SensenutsTM  users for
 * research purpose only. No portion of this source code
 * may be used as the basis of development of any similar
 * kind of product.
 *
 */

#include <jendefs.h>
#include <AppHardwareApi.h>
#include <AppQueueApi.h>

#include "clock.h"  //provides clock related functionality
#include "node.h"
#include "task.h"

/*******************************Do not modify above this line********************************/

//add header for communication with PC
#include "pcInterface.h"

//add header files for mac layer APIs
#include "mac.h"

//user defined packet type should always be greater than 0x23 as routing protocols
//define their packet types below this value.
#define USER_PACKET_TYPE 0x30

//*******************************************************************************
//Program execution starts from this function. It is like main function
//*******************************************************************************
void startNode()
{
//initialize mac layer
	macInit();

//initialize port to communicate with PC
	sendToPcInit();
}

//*******************************************************************************
//              All the tasks added by user expire in this function
//*******************************************************************************
void userTaskHandler(uint8 taskType)
{
}

//*******************************************************************************
//When a data packet from network is received, this function gets called from OS.
//*******************************************************************************
void userReceiveDataPacket(uint8* payload,uint8 length,uint16 prevAddr,uint8 linkQuality)
{
	uint8 tmp;
	uint16 light;

	if (payload[0]==USER_PACKET_TYPE)
	{
		tmp=payload[1];
		light=payload[2];
		light=light<<8;
		light=light | payload[3];

		//update info in database present in PC
		updateSTLdb(prevAddr,light,tmp);
	}
}

//*******************************************************************************
//                  A dio event is received in this function. 
//*******************************************************************************
void userCriticalTaskHandler(uint8 critTaskType)
{
	
}

//#########################################################################################################################################
//														A very special function
//#########################################################################################################################################

//*******************************************************************************
//  this function gets called if receive from pc is enabled and a byte 
//  is received from pc. This is getting called from interrupt handler
//  unlike other functions which were all scheduled by OS. This being 
//  an interrupt handler, must be having least possible statements so 
//  that the device comes back to normal operation out of interrupt quickly.
//*******************************************************************************
void pcInterruptHandler()
{
}
