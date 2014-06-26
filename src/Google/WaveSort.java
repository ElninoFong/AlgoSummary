package Google;

//=============
//	Question
//=============
/* 
 * http://www.careercup.com/question?id=5145759489982464
 * Given an array of integers, sort the array into a wave like array, namely a1 >= a2 <= a3 >= a4 <= a5.....
 */

//=============
//	Solution
//=============
/*
 * O(nlgn) solution: Sort array first and swap pairs of numbers
 * 
 * O(n) solution:
 * 1. You can find the median in O(n) and then rearrange the elements around the median
		Find the kth smallest element in O(n) time:	Quickselect, Median-of-medians ...
		http://goo.gl/XIiQ0z
 * 
 * 2. (Better Solution) If you notice the desired ordering, the even numbered elements are bigger (or equal) than the next element, 
		and the odd numbered elements are less than (or equal) than the next element, of course I am assuming the array is 0 offset.
		So, you can iterate the array and swap the elements that doesn't match this arrangements,
		e.g., swap A[i] and A[i+1], when i is even and A[i] < A[i + 1].
 * 
 * Prove: 
 	从第一个数开始往右扫描， 我们要做的是当扫描到第i个数的时候， 前i个数必须满足 a[0] <=a[1] >= a[2] .... a， 当i为n就结束了
	当i为0, 2, 4...，前i - 1个元素已经满足了。 如果a[ i ] > a[i + 1] 交换a[ i ] 和 a[i + 1]， 这样使得前i个都满足, 因为a[i + 1] 必然小于a[ i - 1]。
	当i为1,3,5... 同理， 如果a[ i ] < a[i + 1], 交换使得前i个满足， 因为a[i + 1] 必然大于a[i - 1]。其余的情况不用理会
	我们每一步都能保证当前和之前的元素都满足这个规律， 所以必然有解。
 */