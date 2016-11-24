// Example of swapping two variables
// using templates and references.
#include <iostream>

template <typename T>
void Swap(T &a, T &b);

int main() {
  using namespace std;
  
  int a = 5;
  int b = 9;
  // before swap
  cout << "a: " << a << endl;
  cout << "b: " << b << endl;
  
  Swap(a, b);
  // after swap
  cout << "a: " << a << endl;
  cout << "b: " << b << endl;
}

template <typename T>
void Swap(T &a, T &b)
{
  T temp;
  temp = a;
  a = b;
  b = temp;
}

