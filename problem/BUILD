java_binary(
    name = "problem",
    srcs = [
        "src/main/java/problem/algorithms/MergeIterator.java",
        "src/main/java/problem/algorithms/MultiSet.java",
        "src/main/java/problem/algorithms/Problem.java",
    ],
    main_class = "problem.MultiSet",
    #    main_class = "problem.Problem",
    #    main_class = "problem.MergeIterator",
    visibility = ["//:__pkg__"],
    deps = [],
)

java_test(
    name = "problem_test",
    srcs = [
        "src/test/java/problem/algorithms/ProblemTest.java",
    ],
    test_class = "problem.algorithms.ProblemTest",
    visibility = ["//:__pkg__"],
    deps = [
        ":problem",
        "@junit",
    ],
)
