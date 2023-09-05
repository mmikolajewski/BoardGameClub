docker build -t pawn .
docker stop pawn || true
docker rm pawn || true
docker run -p 8080:8080 -v /root/uploads/img:/uploads/img --name pawn pawn
