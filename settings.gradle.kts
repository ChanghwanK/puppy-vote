rootProject.name = "puppy-vote"

include("puppy-vote-domain")
include("puppy-vote-interfaces:web")

include("puppy-vote-infrastructure:persistence-database")
include("puppy-vote-infrastructure:persistence-redis-adapter")
include("puppy-vote-infrastructure:persistence-kafka-adapter")
