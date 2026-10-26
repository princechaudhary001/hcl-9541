 HCL Training - Java

Code written during the HCL training, organised module by module. Each folder is a Java package and every
file has its own `main()` so it can be run on its own.

## Modules

| # | Module | Folder | Topics covered |
|---|--------|--------|----------------|
| 1 | Java Basics | [`javabasics/`](javabasics) | Hello World & printf, data types, operators, type casting, if/switch, loops & patterns, arrays (1D/2D/jagged), methods (overloading, varargs, recursion, pass-by-value), Scanner input |
| 2 | Core Java | [`corejavafoundation/`](corejavafoundation) | static & final, string handling & StringBuilder, wrapper classes & autoboxing, exception handling (custom, try-with-resources), inner classes & enums, generics, lambdas & streams |
| 3 | OOP | [`OOPS/`](OOPS) | Encapsulation, inheritance, polymorphism, abstraction (abstract class / interface), Object class (`equals`/`hashCode`/`toString`), constructors, static method hiding |
| 4 | Constructors | [`Constructorcheck/`](Constructorcheck) | Constructor overloading, object creation |
| 5 | Collection Framework | [`CollectionFrameWork/`](CollectionFrameWork) | ArrayList, LinkedList, Stack, Queue, PriorityQueue/Deque, Set (Hash/Linked/Tree), Map (Hash/Linked/Tree), Comparable vs Comparator, Collections utilities, HashMap internals, concurrent collections, interview problems |

## Collection Framework files

| File | What it shows |
|------|---------------|
| `Array.java`, `ArrayListDemo.java` | ArrayList, ListIterator, sorting, sublists, immutable lists |
| `LinkedListt.java` | LinkedList as list, queue and deque |
| `StackClass.java` | Stack vs ArrayDeque, balanced brackets |
| `QueueClass.java`, `QueueAndPriorityQueueDemo.java` | Queue, PriorityQueue (min/max heap, k-th largest), Deque |
| `SetsDemo.java` | HashSet / LinkedHashSet / TreeSet, set operations |
| `Maps.java`, `MapTypesDemo.java` | HashMap / LinkedHashMap / TreeMap, `merge`, `compute`, LRU cache |
| `WordFrequency.java` | Word count, two-sum, anagram, first non-repeating character |
| `ComparableComparatorDemo.java`, `Task1.java` | Sorting objects with Comparable and Comparator |
| `CollectionsUtilityDemo.java` | `Collections` helpers, fail-fast iterators |
| `HashMapInternalsDemo.java` | `hashCode`/`equals`, collisions, buckets, resizing |
| `ConcurrentCollectionsDemo.java` | ConcurrentHashMap, CopyOnWriteArrayList, Hashtable, BlockingQueue |

## How to run

Requires JDK 17 or newer.

```bash
# compile everything into ./bin
javac -d bin $(find . -name "*.java" -not -path "./out/*")

# run any class by its package name
java -cp bin javabasics.HelloWorld
java -cp bin CollectionFrameWork.MapTypesDemo
java -cp bin OOPS.PolymorphismDemo
```

Or open the folder in IntelliJ IDEA and run any `main()` with the green arrow.
