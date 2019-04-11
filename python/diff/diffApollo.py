import difflib
import sys

config = '''# 提交配置
aaa=222
# sasas
# 3333
bb=111'''
r1 = config.split("\n")
r2 = []
is_comment = True
comment = ""
for i in r1:
    if i == "":
        continue
    if i[0] == "#":
        comment = i
    else:
        key = i + comment
        r2.append(key)

print(r2)

# s1 = ['a=1', 'b=1', 'c=1', 'd=1', 'e=1']
# s2 = ['a=1', 'b=2', 'e=1', 'c=1', 'f=1']
# result = []
# res = {}
# i = 0
# for line in difflib.unified_diff(s1, s2, tofile="to.py", fromfile="from.py"):
#     i = i + 1
#     if i > 3:
#         if line[0] == "+" or line[0] == "-":
#             result.append(line)
# result.sort()
# result.reverse()
# for item in result:
#     if item[0] == '-':
#         i1 = item.split("=")
#         key = i1[0][1:]
#         op = 'delete'
#     else:
#         i1 = item.split("=")
#         key = i1[0][1:]
#         op = 'add'
#         if res.get(key):
#             op = "modify"
#     res[key] = {"op": op, "key": key, "value": i1[1],'comment':'comment'}
#     # sys.stdout.write(line+"\r\n")
# print(res)
