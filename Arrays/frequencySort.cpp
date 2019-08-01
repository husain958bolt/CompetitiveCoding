#include <iostream>
#include <bits/stdc++.h>
using namespace std;

unordered_map<int,pair<int,int>> um;

bool comp(int a, int b) {
	auto p1 = um[a];
	auto p2 = um[b];
	if (p1.second == p2.second)
		return p1.first < p2.first;
	return p1.second > p2.second;
}

int main() {
	// your code goes here
	vector<int> a={2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
	
	for (int i=0; i<a.size(); i++) {
		if (um.count(a[i])==0) {
			um[a[i]] = make_pair(i,1);
		}
		else {
			auto p = um[a[i]];
			p.second = p.second+1;
			um[a[i]] = p;
		}
	}
	sort(a.begin(),a.end(),comp);
	for (auto x : a)
		cout<<x<<" ";
	cout<<endl;
	
	return 0;
}
