const std = @import("std");
const warn = @import("std").debug.warn;
const assert = @import("std").debug.assert;

pub fn main() void {
    var x: i32 = 1;
    const ptr = &x;
    ptr.* += 1;
    x += 1;
    assert(ptr.* == 3);
}