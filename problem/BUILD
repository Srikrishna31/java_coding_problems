java_binary(
    name = "problem",
    srcs = [
        "src/main/java/problem/algorithms/DropBallDownStairs.java",
        "src/main/java/problem/algorithms/MergeIterator.java",
        "src/main/java/problem/algorithms/MultiSet.java",
        "src/main/java/problem/algorithms/ReverseLinkedListGroups.java",
        "src/main/java/problem/algorithms/SortedArrayMerge.java",
    ],
    #    main_class = "problem.algorithms.MultiSet",
    #    main_class = "problem.algorithms.SortedArrayMerge",
    main_class = "problem.algorithms.MergeIterator",
    visibility = ["//:__pkg__"],
    deps = [],
)

java_test(
    name = "problem_test",
    srcs = [
        "src/test/java/problem/algorithms/DropBallDownStairsTest.java",
        "src/test/java/problem/algorithms/MergeIteratorTest.java",
        "src/test/java/problem/algorithms/MultiSetTest.java",
        "src/test/java/problem/algorithms/ReverseLinkedListGroupsTest.java",
        "src/test/java/problem/algorithms/SortedArrayMergeTest.java",
    ],
    test_class = "problem.algorithms.DropBallDownStairsTest",
    visibility = ["//:__pkg__"],
    deps = [
        ":problem",
        "@junit",
    ],
)
