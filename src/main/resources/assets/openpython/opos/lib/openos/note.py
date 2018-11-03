# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/note.lua

note = {}
notes = {}  # The table that maps note names to their respective MIDI codes
reverseNotes = {}  # The reversed table "notes"

tempNotes = ["c", "c#", "d", "d#", "e", "f", "f#", "g", "g#", "a", "a#", "b"]
sNotes = ["a0", "a#0", "b0"]
bNotes = ["bb0"]

for i in range(1, 6 + 1):
    for v in tempNotes:
        sNotes.append(v + str(i))
        if len(v) == 1 and v != "c" and v != "f":
            bNotes.append(v + "b" + str(i))

for v in range(21, 95 + 1):
    k = sNotes[v - 20 - 1]
    notes[k] = str(v)
    reverseNotes[v] = k

# TODO: ?
raise NotImplementedError
