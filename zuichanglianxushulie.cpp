#include <stdio.h>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;
int main(){
    //存储数据,时间复杂度为排序复杂度O(nlogn)
    vector<int> nums={1,2,0,1};
    vector<int> sortnums=nums;
    sort(sortnums.begin(),sortnums.end());
    int len=0,maxlen=0;
    for(int i=0;i<sortnums.size();i++){
        if(i==0||sortnums[i]-sortnums[i-1]==1){
            len++;
            maxlen=max(maxlen,len);
        }
        else if (sortnums[i]==sortnums[i-1])
        {
            continue;
        }
        else{
            len=1;
        }
        
        
    }
    printf("1 :%d",maxlen);
    //使用哈希表存储，时间复杂度为O(n)
    unordered_map<int,int> numset;
    maxlen=0;
    int left=0,right=0;
    for(int i=0;i<nums.size();i++){
        if(!numset[nums[i]]){
            left=numset[nums[i]-1]?numset[nums[i]-1]:0;
            right=numset[nums[i]+1]?numset[nums[i]+1]:0;
            maxlen=max(maxlen,left+right+1);
            numset[nums[i]]=left+right+1;
            numset[nums[i]-left]=left+right+1;
            numset[nums[i]+right]=left+right+1;
        }
    }
    printf("\n2 :%d",maxlen);
}
