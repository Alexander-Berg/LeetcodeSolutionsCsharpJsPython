import unittest
from SimplifyPath import SimplifyPath

class TestSimplifyPath(unittest.TestCase):
    def test_empty_path(self):
        path = ""
        expected_output = "/"
        self.assertEqual(SimplifyPath().simplifyPath(path), expected_output)

    def test_root_path(self):
        path = "/"
        expected_output = "/"
        self.assertEqual(SimplifyPath().simplifyPath(path), expected_output)

    def test_single_level_path(self):
        path = "/abc"
        expected_output = "/abc"
        self.assertEqual(SimplifyPath().simplifyPath(path), expected_output)

    def test_multiple_level_path(self):
        path = "/abc/def/ghi"
        expected_output = "/abc/def/ghi"
        self.assertEqual(SimplifyPath().simplifyPath(path), expected_output)

    def test_relative_path(self):
        path = "abc/def/../../xyz"
        expected_output = "/xyz"
        self.assertEqual(SimplifyPath().simplifyPath(path), expected_output)

    def test_complex_path(self):
        path = "/a/./b/../../c/"
        expected_output = "/c"
        self.assertEqual(SimplifyPath().simplifyPath(path), expected_output)

if __name__ == '__main__':
    unittest.main()

