package test1_9;



/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * @author WOQUQ
 *
 */
public class Test8 {
    public static int myAtoi(String str) {
    	if(str.length() == 0) return 0;
    	
    	boolean beginFlag = false; //检测数据是否已经开始录入
    	boolean negativeFlag = false;//检测数据是否是负数
    	boolean firstFlag = true;//检测当前数是否是录入的第一个数
    	
    	int res = 0;
    	
        for(int i = 0; i < str.length(); i++) {
        	char temp = str.charAt(i);
        	switch (temp) {
			case ' ':
				//如果数据已经开始录入，若检测到空格则直接返回res
				if(beginFlag) return res;
				//如果数据还未录入，则忽视此空格
				break;
			case '+':
				//如果检测到数据已经开始录入，则返回res
				if(beginFlag) return res;
				//如果数据还未开始录入，则开始录入
				else beginFlag = true;
				break;
			case '-':
				//如果检测到数据已经开始录入，则返回res
				if(beginFlag) return res;
				//如果数据还未开始录入，则开始录入，并将数据记为负数
				else{
					beginFlag = true;
					negativeFlag = true;
				}
				break;
			case '0':
				//如果数据还未开始录入，则开始录入
				if(!beginFlag) beginFlag = true;
				//如检测到这不是录入的第一个数，则将其记入res中
				if(firstFlag) {
					//如检测到数据超范围，则直接返回
					if(res > Integer.MAX_VALUE/10) return Integer.MAX_VALUE;
					if(res < Integer.MIN_VALUE/10) return Integer.MIN_VALUE;
					res = res*10;

					
				}
				//如检测到这是录入的第一个数，则忽视
				break;
			case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
				//如果数据还未开始录入，则开始录入
				if(!beginFlag) beginFlag = true;
				
				//如检测到数据超范围，则直接返回
				if(res > Integer.MAX_VALUE/10 ||(res == Integer.MAX_VALUE/10 && Integer.valueOf(temp)-48 > 7)) return Integer.MAX_VALUE;
				if(res < Integer.MIN_VALUE/10 ||(res == Integer.MIN_VALUE/10 && Integer.valueOf(temp)-48 > 8)) return Integer.MIN_VALUE;
				
				if(!negativeFlag) res = res*10 + Integer.valueOf(temp)-48;
				else {
					if(res>0) res = -res;
					res = res*10 - Integer.valueOf(temp)+48;
				}
				break;
			default:
				return res;
				
			}
        	
        }
        return res;
    }
    public static void main(String[] args) {
    	//System.out.println(Integer.valueOf('1'));
		System.out.println(myAtoi("-2147483649"));
	}
    
}
