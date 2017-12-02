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
#include "node.h"		//provides getNodeId and remainingBattery
#include "task.h"		//provides addTask

/*******************************Do not modify above this line********************************/

//add header files for temperature and light sensors
#include "tmpSensor.h"
#include "lightSensor.h"

//add header for communication with PC
#include "pcInterface.h"

//task type to be used in this demo
#define SEND_TO_PC 0

//*******************************************************************************
//Program execution starts from this function. It is like main function
//*******************************************************************************
void startNode()
{
//initialize sensors
	tmpInit();
	lightSensorInit();

//initialize port to communicate with PC
	sendToPcInit();

//set task to read sensor info and send to PC
	addTask(USER,SEND_TO_PC,1*SECOND);
}

//*******************************************************************************
//              All the tasks added by user expire in this function
//*******************************************************************************
void userTaskHandler(uint8 taskType)
{
	uint8 tmp;
	uint16 light;

	//read sensor values
	tmp=readTmp();
	light=readLux();

	//update info in database present in PC
	updateSTLdb(getNodeId(),light,tmp);

	//add next task
	addTask(USER,SEND_TO_PC,1*SECOND);

	
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
