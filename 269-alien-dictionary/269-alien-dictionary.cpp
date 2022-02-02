class Solution{
    public: string alienOrder(vector<string> words){
        if (words.size() == 0){
            return "";
        }
        
        unordered_map<char, int> indegrees;
        unordered_map<char, unordered_set<char>> adjList;
        
        for (string str : words){
            for (char ch : str){
                indegrees[ch] = 0;
            }
        }
        
        for (int i = 0; i+1 < words.size(); i++){
            string word1 = words[i];
            string word2 = words[i+1];
            
            int minLen = min(word1.length(), word2.length());
            int j = 0;
            for (; j  < minLen; j++){
                if (word1[j] != word2[j]){
                                                            

                        
                    if (adjList[word1[j]].count(word2[j]) == 0){
                        adjList[word1[j]].insert(word2[j]);
                        indegrees[word2[j]]++;
                    }
                    
                        break;
                }
                    
            }
               if (j == minLen && word1.length() > word2.length()){
                    return "";
                }
        }
        
        queue<char> q;
        for (auto& entry : indegrees){
            if (entry.second == 0){
                q.push(entry.first);
            }
        }
        
        string res;
        while (!q.empty()){
            char current = q.front();
            q.pop();
            res.push_back(current);
            for (char ch : adjList[current]){
                if (--indegrees[ch] == 0){
                    q.push(ch);
                }
            }
        }
        if (indegrees.size() != res.length()){
            return "";
        }
        return res;
    }
};