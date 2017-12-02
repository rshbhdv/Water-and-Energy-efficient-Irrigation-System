#include <jendefs.h>
#include <AppHardwareApi.h>
#include <AppQueueApi.h>

#include "clock.h"  //provides clock related functionality
#include "node.h"		//provides getNodeId and remainingBattery
#include "task.h"		//provides addTask

#include "tmpSensor.h"
#include "lightSensor.h"

#include "pcInterface.h"
#define SEND_TO_PC 0

void startNode()
{

	tmpInit();
	lightSensorInit();
	sendToPcInit();
	addTask(USER,SEND_TO_PC,1*SECOND);
}

void userTaskHandler(uint8 taskType)
{
	uint8 tmp;
	uint16 light;

	tmp=readTmp();
	light=readLux();


	updateSTLdb(getNodeId(),light,tmp);

	addTask(USER,SEND_TO_PC,1*SECOND);


}

void userReceiveDataPacket(uint8* payload,uint8 length,uint16 prevAddr,uint8 linkQuality)
{

}

void userCriticalTaskHandler(uint8 critTaskType)
{

}

void pcInterruptHandler()
{
}
