import os
import subprocess

def execute_command(cmd):
    popen = subprocess.Popen(cmd, stdout=subprocess.PIPE, universal_newlines=True)
    for stdout_line in iter(popen.stdout.readline, ""):
        yield stdout_line.strip()
    popen.stdout.close()
    return_code = popen.wait()
    if return_code:
        yield "Non zero exit code"

def run_testcase(program_name, test_case):
    input, expected_output = map(lambda x: x.strip(), test_case.split("->"))
    test_main = "./tests/_temp.ps"

    with open(test_main, mode="w") as f:
        parameter_count = input.count(" ") + 1
        f.write(input + f" {parameter_count} execute = quit")
    
    actual_output = list(execute_command(["C:/Program Files/gs/gs9.53.3/bin/gswin64c.exe", f"./programs/{program_name}.ps", "./instructions.ps", "./vm.ps", test_main]))[-1]

    os.remove(test_main)

    if (actual_output == expected_output):
        print(f"✔️ {program_name}: {test_case}")
    else:
        print(f"❌ {program_name}: {test_case}")
        print(f"Expected: {expected_output}")
        print(f"  Actual: {actual_output}")
        print()

def run_test(program_name):
    print(f"Running tests for '{file}'.")
    program_name = file.replace(".test", "")
    with open(os.path.join("./tests/", f"{program_name}.test")) as f:
        for test_case in f:
            run_testcase(program_name, test_case.strip())

for file in os.listdir("./tests"):
    if file.endswith(".test"):
        run_test(file.replace(".test", ""))
        print()
