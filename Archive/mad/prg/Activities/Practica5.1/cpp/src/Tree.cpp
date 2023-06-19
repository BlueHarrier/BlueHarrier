// IOStream library
#include <iostream>
using namespace std;

// Branch class
class Branch{
    public : int calculateHeight(){
        // Initialize the branches and current height
        int branches;
        cin >> branches;
        int height = 0;

        // Execute each branch
        Branch* branch = new Branch();
        for (int i = 0; i < branches; i++){
            int branchHeight = branch->calculateHeight();
            if (branchHeight > height){
                height = branchHeight;
            }
        }
        delete branch;

        // Add and return height
        height++;
        return height;
    }
};

// Main function
int main() {
    // Pick up the number of cases
    int cases;
    cin >> cases;

    // Execute for each tree
    Branch* root = new Branch();
    for (int i = 0; i < cases; i++){
        cout << root->calculateHeight() << "\n";
    }
    delete root;
}