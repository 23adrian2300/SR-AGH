import subprocess


class RequestHandler:
    def __init__(self, server):
        self.server = server
        self.grpcurl = "./grpcurl.exe"
        self.plainText = "-plaintext"

    # This method is used to check if the connection to the server is successful
    def test_connection(self):
        args = [self.grpcurl, self.plainText, self.server, "list"]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return False, stderr.decode()
            return True, stdout.decode()
        except Exception as e:
            return False, str(e)

    # This method is used to get the list of services available on the server
    def get_services(self):
        args = [self.grpcurl, self.plainText, self.server, "describe"]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return stderr.decode()
        except Exception as e:
            return e
        return stdout.decode()

    # This method is used to get the specific service description
    def describe_service(self, obj):
        args = [self.grpcurl, self.plainText, self.server, "describe", obj]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return stderr.decode()
        except Exception as e:
            return e
        return stdout.decode()

    # This method gets the result of the operation
    def get_operation_result(self, operation, numbers):
        args = [self.grpcurl, self.plainText, "-d", f'{{"operationtype": "{operation}", "arguments": {numbers}}}']
        args += [self.server, "calculator.Calculator/Operation"]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return stderr.decode()
        except Exception as e:
            return e
        return stdout.decode()

    # This method gets the result of the composite tester
    def get_composite_tester_result(self, number):
        args = [self.grpcurl, self.plainText, "-d", f'{{"number": {number}}}' if number is not None else "{}"]
        args += [self.server, "calculator.Calculator/CompositeTester"]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return stderr.decode()
        except Exception as e:
            return e
        return stdout.decode()

    # This method gets the result of the stream composite numbers
    def get_stream_composite_numbers_result(self, max_value):
        args = [self.grpcurl, self.plainText, "-d", f'{{"max": {max_value}}}' if max_value is not None else "{}"]
        args += [self.server, "calculator.CompositeService/GenerateCompositeNumbers"]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return stderr.decode()
        except Exception as e:
            return e
        return stdout.decode()

    # This method gets the result of the list composite numbers
    def get_list_composite_numbers_result(self, max_value):
        args = [self.grpcurl, self.plainText, "-d", f'{{"max": {max_value}}}' if max_value is not None else "{}"]
        args += [self.server, "calculator.CompositeService/GetCompositeNumbersList"]
        try:
            subproc = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = subproc.communicate()
            if stderr:
                return stderr.decode()
        except Exception as e:
            return e
        return stdout.decode()
