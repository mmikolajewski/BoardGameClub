docker build -t pawn .
docker stop pawn || true
docker rm pawn || true
docker run -d -p 8080:8080 -v /root/uploads/img:/uploads/img --name=pawn -e SPRING_PROFILES_ACTIVE=prod,server --network pawngames-network --restart unless-stopped --name pawn pawn
