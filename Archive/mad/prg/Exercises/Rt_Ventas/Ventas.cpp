#include <iostream>

using namespace std;

static const string dayName[] = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

class Week{
	private:
		int day[6];
	
	public:
		void addValue(uint8_t daySet, int val){
			if (daySet >= 0 && daySet < 6){
				day[daySet] = val;
			}
		}
		
		string getBestDay(){
			uint8_t bestDay = 0;
			for (uint8_t i = 1; i < 6; i++){
				if (day[i] > day[bestDay]) bestDay = i;
				else if (day[i] == day[bestDay]) return "EMPATE";
			}
			return dayName[bestDay];
		}
		
		string getWorstDay(){
			uint8_t worstDay = 0;
			for (uint8_t i = 1; i < 6; i++){
				if (day[i] < day[worstDay]) worstDay = i;
				else if (day[i] == day[worstDay]) return "EMPATE";
			}
			return dayName[worstDay];
		}
		
		bool getSundayOverAvg(){
			int avg = 0;
			for (uint8_t i = 0; i < 6; i++){
				avg += day[i];
			}
			avg /= 6;
			return (day[5] > avg);
		}
};

int main(){
	uint8_t d = 0;
	string str;
	int val;
	int avg = 0;
	Week* week = new Week();
	
	do{
		getline(cin, str);
		int ppos = str.find_first_of('.');
		if (ppos < str.length())
			str.erase(str.find_first_of('.'), 1);
		else
			str += "00";
		val = stoi(str);
		week->addValue(d, val);
		
		if (d < 5) d++;
		else {
			d = 0;
			cout << week->getBestDay() << " " << week->getWorstDay() << " ";
			if (week->getSundayOverAvg()){
				cout << "SI";
			}
			else{
				cout << "NO";
			}
			cout << endl;
		}
	}while (!(d == 1 && val == -100));
	
	delete week;
	return 0;
}