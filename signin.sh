if [ -z "$1" ]
then
    echo "usage ./signin.sh <You ID>"
    exit 1
fi

git checkout -b $1
