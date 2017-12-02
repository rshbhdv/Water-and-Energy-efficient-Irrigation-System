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

#ifndef  CONFIG_H_
#define  CONFIG_H_

#if defined __cplusplus
extern "C" {
#endif

/****************************************************************************
 Device Options available in sensenuts are:
1) FFD_PAN_COORDINATOR
2) FFD_COORDINATOR
3) RFD_DEVICE
 
 define the node type.
 ***************************************************************************/
#define FFD_PAN_COORDINATOR 


/***************************************************************************
Device supports following routing protocols currently:
1) MAC_BASED_ROUTING (MBR)   - This routing algorithm is applicable for sending
   	   	   	   	   	   	       data to pan coordinator with address 0.
2) LEVEL_BASED_ROUTING (LBR) - This routing algorithm is applicable for sending
   	   	   	   	   	   	       data to pan coordinator with address 0.
3) AODV

***************************************************************************/
#define MAC_BASED_ROUTING

#if defined __cplusplus
}
#endif

#endif 
