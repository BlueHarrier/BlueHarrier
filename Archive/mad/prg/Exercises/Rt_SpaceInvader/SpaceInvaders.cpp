#include <iostream>

using namespace std;

int main(){
    int cases;
    cin >> cases;
    while (cases-- > 0){
        int records;
        cin >> records;
        int doubleRecords = records * 2;
        char* output = new char[records * 3];
        for (int i = 0; i < records; i++){
            char* name = new char[3];
            cin >> name;
            output[i] = name[0];
            output[i + records] = name[1];
            output[i + doubleRecords] = name[2];
        }
        cout << output << endl;
        delete output;
    }
    return 0;
}