plugins {
    `swift-library` // <1>
    xctest // <2>
}

library {
    targetMachines.add(machines.linux.x86_64) // <3>
}
