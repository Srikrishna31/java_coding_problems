java_binary(
    name = "problem",
    srcs = [
        "src/main/java/problem/MergeIterator.java",
        "src/main/java/problem/MultiSet.java",
        "src/main/java/problem/Problem.java",
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
        "src/test/java/problem/ProblemTest.java",
    ],
    test_class = "problem.ProblemTest",
    visibility = ["//:__pkg__"],
    deps = [
        ":problem",
        "@junit",
    ],
)
