f = (time, start, change, dur) ->
	time /= dur
	change * (time ^ 3) + start # this, being the last line, is returned

a = 0
s = 0
d = 100
step = (frame) ->
	setTimeout step(frame + 1), 100 if frame < 200
	a = f frame, s, 1, d
	console.log((f * 10) + "ms\t" + a + "%")
step(0)
