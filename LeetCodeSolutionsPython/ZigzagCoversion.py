class ZigzagConcersion:
    def convert(self, s: str, numRows: int) -> str:
        if len(s) < 3 or numRows == 1:
            return s

        out = []
        n = numRows
        m = 2 * n - 2
        for i in range(n):
            x = i
            count = 1
            while x < len(s):
                out.append(s[x])
                if count % 2 == 0 and i != 0:
                    x += (2 * i)
                elif count % 2 == 1 and i != n - 1:
                    x += (m - (2 * i))
                else:
                    x += m
                count += 1

        return ''.join(out)





