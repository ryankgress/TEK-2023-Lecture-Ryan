const person = {
    name: 'John',
    age: 30,
    location:'FL'
}

function add(x,y) {
    return x + y
}

console.log(add(2,5))

const nums = [11,30,22,8,14]

const sum = nums.reduce((acc, cur) => acc + cur)
const over = nums.filter(num => num > 20)


over
sum