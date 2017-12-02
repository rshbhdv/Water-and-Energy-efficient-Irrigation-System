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

//add header files for temperature and light sensors
#include "tmpSensor.h"
#include "lightSensor.h"

////add dio.h for using led related APIs
#include "dio.h"

//add header files for mac layer APIs
#include "mac.h"

//task type to be used in this demo
#define SEND_PACKET_TO_MAC 0

//user defined packet type should always be greater than 0x23 as routing protocols
//define their packet types below this value.
#define USER_PACKET_TYPE 0x30

//*******************************************************************************
//Program execution starts from this function. It is like main function
//*******************************************************************************
void startNode()
{
//initialize sensors
	tmpInit();
	lightSensorInit();

//initialize mac layer
	macInit();

/*set task to read sensor info and send the data to mac. If
  the coordinator has already associated, it will broadcast
  this packet or else it will drop the packet.*/

	addTask(USER,SEND_PACKET_TO_MAC,5*SECOND);
}

//*******************************************************************************
//              All the tasks added by user expire in this function
//*******************************************************************************
void userTaskHandler(uint8 taskType)
{
	uint8 packet[4];
	uint8 tmp;
	uint16 light;
	bool check;

	//read sensor values
	tmp=readTmp();
	light=readLux();

	//create packet to send on network
	packet[0]=USER_PACKET_TYPE;
	packet[1]=tmp;
	packet[2]=light>>8;
	packet[3]=light;

	//calling API to  send the packet to mac layer
	check=sendDataToMac(packet,4,0xFFFF,0,FALSE);	//16 bit broadcast address with no ack req. Mac ack should be disabled
													//when broadcast is done.

	if (check==FALSE)
	{
		/*do something to let user know that broadcast failed as the
		  node is not associated with any pan coordinator right now */
	}

	//add task to repeat the same thing
	addTask(USER,SEND_PACKET_TO_MAC,1.2*SECOND);
}

//*******************************************************************************
//When a data packet from network is received, this function gets called from OS.
//******************************************************************************* 
void userReceiveDataPacket(uint8* payload,uint8 length,uint16 prevAddr,uint8 linkQuality)
{

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
