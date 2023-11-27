CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

# Step 2: Check if the student has submitted the correct Java file
if [ ! -e student-submission/ListExamples.java ]; then
    echo "Error: The required Java file (ListExamples.java) is missing in the submission."
    exit 1
fi

# Step 3: Move necessary files to the grading area
cp student-submission/ListExamples.java grading-area/
cp TestListExamples.java grading-area/


# Step 4: Compile the tests and student's code
javac -cp $CPATH grading-area/*.java

if [ $? -ne 0 ]; then
    echo "Error: Compilation failed. Check your code and try again."
    exit 1
fi

# Step 5: Run the tests and report the grade
test_output=$(java -cp $CPATH org.junit.runner.JUnitCore ListExamples 2>&1)

# Count the number of test failures
#num_failures=$(echo "$test_output" | grep -o "Failures: [0-9]*" | awk '{print $2}')

# Report the number of failures
#if [ $num_failures -eq 0 ]; then
    #echo "Passed: All tests passed."
#else
    #echo "Failed: $num_failures test(s) did not pass."
#fi
num_failures=$(echo "$test_output" | grep -oP 'Tests run: \K[0-9]+, Failures: \K[0-9]+')

# Extract the failure count
if [ -n "$num_failures" ]; then
    echo "Failed: $num_failures test(s) did not pass."
else
    echo "Passed: All tests passed!!"
fi


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
