package com.leetcodeblind75;


/* Given an Array of int  it is a valid Mountain if it is strictly increasing first
 then strictly decreasing 
 */ 


public class ValidMountain {


  /*
  if array length is less than 3 return false 
  while leftIndex is less than arraySize-1-1  and left item is less than leftIndex+1 item , increase leftIndex 
 while rightIndex is greater than 0  and right item is less than rightIndex+1 item , decrease rightIndex 

  
  */
    public static void main(String[] args) {

        System.out.println(isValidMountain(new int[]{0,1,2,3,4,5,6,7,4,2,1}));
        System.out.println("###################################");
        
        System.out.println(isValidMountain(new int[]{10,8,7,5,4,2,1}));
        System.out.println("###################################");
        System.out.println(isValidMountain(new int[] {0,1,2,3,2,1}));
        System.out.println("###################################");
        System.out.println(isValidMountain(new int[] {0,1,4,5,5,3,2,1}));
        System.out.println("###################################");
        System.out.println(isValidMountain(new int[] {0,3,2,1}));
    
}

    private static boolean isValidMountain(int[] arr) {

      int left =0;
      int right = arr.length-1;
     
       if(arr.length<3){
        return false;
       }

  
        while( left <arr.length-2 && arr[left]<arr[left+1]){ 
        left++;
        }
        while(right > 0 && arr[right] < arr[right-1]){ // dont assign left left changed from 0 
           right--;
        }
    
     //left!=0 && right!=0 what if it is only increasing or only decreasing 
      return left!=0 && right!=0 && left== right;

     }
       
    }
