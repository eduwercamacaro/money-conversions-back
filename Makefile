gradle=./gradlew

run-db:
	@ docker run -d --rm \
		-e TZ=America/Guayaquil \
		-e POSTGRES_DB=conversionsdb \
		-e POSTGRES_PASSWORD=postgres \
		-e POSTGRES_USER=postgres \
		-p 5432:5432 \
		--name postgres \
		postgres

clean:
	@ $(gradle) clean

test: clean
	@ $(gradle) test

run: clean
	@ $(gradle) bootRun