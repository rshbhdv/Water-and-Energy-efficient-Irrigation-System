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
#include "node.h"	//provides getNodeId and remainingBattery
#include "task.h"   //provides addTask

/*******************************Do not modify above this line********************************/

//add dio.h for using led related APIs
#include "dio.h"

//task types to be used in this demo
#define LED_ON 0
#define LED_OFF 1

//*******************************************************************************
//Program execution starts from this function. It is like main function
//*******************************************************************************
void startNode()
{
//set task to switch on the led
	addTask(USER,LED_ON,1*SECOND);
}

//*******************************************************************************
//              All the tasks added by user expire in this function
//*******************************************************************************
void userTaskHandler(uint8 taskType)
{
	//check the current taskType and accordingly take the decision.
	switch (taskType)
	{
		case LED_ON:
			ledOn();
			addTask(USER,LED_OFF,1*SECOND);
			break;
		case LED_OFF:
			ledOff();
			addTask(USER,LED_ON,1*SECOND);
			break;
	}
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
