#include <stdio.h>
#include <vector>
#include <string>
#include <unordered_map> 
#include <iostream>
#include <algorithm>
using namespace std;
//1.将字母转换为质数，将单词转换为质数乘积，将质数乘积相同的单词放在一起（即具有相同字母的单词），map存储质数乘积和单词，最后将map的value转为vector输出
//2.如果不使用单词转换为质数乘积，直接将单词排序，将排序后的单词作为key，将原单词作为value，存储在map中，最后将map的value转为vector输出
int main() {
    // 输入
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    // 质数表
    unordered_map<char, int> mp = {
    {'a', 2}, {'b', 3}, {'c', 5}, {'d', 7}, {'e', 11}, {'f', 13}, {'g', 17}, 
    {'h', 19}, {'i', 23}, {'j', 29}, {'k', 31}, {'l', 37}, {'m', 41},
    {'n', 43}, {'o', 47}, {'p', 53}, {'q', 59}, {'r', 61}, {'s', 67}, 
    {'t', 71}, {'u', 73}, {'v', 79}, {'w', 83}, {'x', 89}, {'y', 97}, {'z', 101}
    };
    unordered_map<double, vector<string>> res;
    unordered_map<string, vector<string>> ressort;
    vector<vector<string>> res1;
    for (string str : strs) {
        string strsort = str;
        sort(strsort.begin(), strsort.end());
        if (ressort.find(strsort) == ressort.end()) {
            ressort[strsort] = vector<string>();
        }
        ressort[strsort].push_back(str);
        double key = 1;
        for (char c : str) {
            key *= mp[c];
        }
        if (res.find(key) == res.end()) {
            res[key] = vector<string>();
        }
        res[key].push_back(str);
    }
    for (auto it = res.begin(); it != res.end(); it++) {
        res1.push_back(it->second);
        for (string str : it->second) {
            cout << str << " ";
        }
        cout << endl;
    }
    //第二种方法
    for (auto it = ressort.begin(); it != ressort.end(); it++) {
        res1.push_back(it->second);
        for (string str : it->second) {
            cout << str << " ";
        }
        cout << endl;
    }
    return 0;
}