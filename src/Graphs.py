import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv('SmallDataWithHybrid.txt')

sizes = data['Array Size']
insertion_sort = data['Insertion Sort']
quick_sort = data['Quick Sort']
hybrid_sort = data['Hybrid Sort']
#heap_sort = data['Heap Sort']
#radix_sort = data['Radix Sort']

plt.plot(sizes, insertion_sort, label='Insertion Sort')
plt.plot(sizes, quick_sort, label='Quick Sort')
plt.plot(sizes, hybrid_sort, label = "Hybrid Sort")
#plt.plot(sizes, heap_sort, label='Heap Sort')
#plt.plot(sizes, radix_sort, label='Radix Sort')

plt.xlabel('Input Size')
plt.ylabel('Execution Time (ns)')
plt.title('Sorting Algorithm Performance')

plt.legend()
plt.xticks(sizes)
plt.tick_params(axis='x', pad=20)
plt.ylim(0, 60000)
plt.show()